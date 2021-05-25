<template>
  <div class="add-friend">
    <div >
      <h1>发送消息</h1>
      <el-form
          :model="loginForm"
          :rules="loginFormRules"
          ref="loginFormRef"
          class="login_form"
          @submit.native.prevent
      >

        <el-form-item prop="username" >
          <el-input
              v-model="loginForm.username"
              prefix-icon="iconfont icon-user"
              class="inputStyle"
              placeholder="username"
              ref="input1"
          ></el-input>
        </el-form-item>

        <el-form-item prop="message" >
          <el-input
              v-model="loginForm.message"
              prefix-icon="iconfont icon-youxiang1"
              class="inputStyle"
              placeholder="message"
              ref="input2"
          ></el-input>
        </el-form-item>

      </el-form>
      <el-button type="primary" @click="addMessage">发送</el-button>
    </div>
  </div>
</template>

<script>

export default {
  name: "AddMessage",
  data() {
    return {
      loginForm: {
        username: "",
        message: ""
      },
      myUsername: "",
      loginFormRules: {
        username: [
          { required: true, message: "请输入用户名称", trigger: "blur" },
          {
            min: 3,
            max: 50,
            message: "长度在 3 到 50 个字符",
            trigger: "blur",
          },
        ],
        message: [
          { required: true, message: "请输入发送内容", trigger: "blur" },
          {
            min: 1,
            max: 200,
            message: "长度在 1 到 200 个字符",
            trigger: "blur",
          },
        ],
      },
    };
  },
  mounted() {
    let userInfo = window.sessionStorage.getItem("userInfo");
    this.userInfo = JSON.parse(userInfo);
    this.myUsername = this.userInfo.username;
  },
  methods: {
    addMessage() {
      this.$refs.loginFormRef.validate(async (valid) => {
        if (!valid) return;
        const time = await new Date();
        await time.setHours(time.getHours() + 8);
        const { data: res } = await this.$http.post("/message/addNewMessage", {
          myUsername: this.myUsername,
          username: this.loginForm.username,
          message:this.loginForm.message,
          time: time,
        });

        if (res.code !== 200) {
          return this.$message.error(res.msg);
        }
        this.$message.success(res.msg);
      });
    },
  },
}
</script>

<style scoped>

</style>
