<template>
  <div class="login_container">
    <!-- 背景图片 -->
    <div class="loginBg">
      <img src="../assets/img/loginbg.jpg" alt />
    </div>
    <div class="login_box">
      <!-- 登录表单区域 -->
      <h1>LOGIN</h1>
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

        <!-- 密码 -->
        <el-form-item prop="password">
          <el-input
            v-model="loginForm.password"
            show-password
            prefix-icon="iconfont icon-password"
            class="inputStyle"
            placeholder="password"
          ></el-input>
        </el-form-item>
        <!-- 按钮区域 -->
        <el-form-item>
          <div class="btns">
            <button class="loginButton button" @click="login">登录</button>
            <button class="goRegButton button" @click="goRegister">
              前往注册
            </button>
            <button class="checkButton button" @click="goHome">
              返回主页
            </button>
          </div>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      loginForm: {
        username: "",
        password: ""
      },
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
        password: [
          { required: true, message: "请输入用户密码", trigger: "blur" },
          {
            min: 1,
            max: 30,
            message: "长度在 1 到 30 个字符",
            trigger: "blur",
          },
        ],
      },
    };
  },
  mounted() {
    this.$refs.input1.focus();
  },
  methods: {
    login() {
      this.$refs.loginFormRef.validate(async (valid) => {
        if (!valid) return;
        const { data: res } = await this.$http.post("/login", this.loginForm);

        if (res.code !== 200) {
          return this.$message.error(res.msg);
        }
        this.$message.success(res.msg);
        window.sessionStorage.setItem("token", res.token);
        window.sessionStorage.setItem("userInfo", JSON.stringify(res.data));
        await this.$router.push("/");
      });
    },
    goRegister() {
      this.$router.push("/register");
    },
    goHome(){
      this.$router.push("/");
    }
  },
};
</script>

<style lang="less" scoped>
.loginBg {
  background-repeat: no-repeat;
  position: absolute;
  width: 100vw;
  height: 100vh;
  img {
    width: 100%;
  }
}
.login_container {
  height: 100%;
}
.login_box {
  width: 500px;
  height: 350px;
  border-radius: 20px;
  background-color: #00000090;
  position: absolute;
  left: 50%;
  top: 50%;
  transform: translate(-50%, -50%);
  h1 {
    color: rgb(240, 199, 218);
    text-align: center;
    margin: 50px 0 0;
  }
}

/deep/.login_form {
  position: absolute;
  bottom: 0;
  width: 100%;
  padding: 0 35px;
  box-sizing: border-box;
  .el-input__inner {
    padding-left: 40px;
    height: 50px;
    background-color: #ffffff90;
    font-size: 18px;
    color: #fff;
    border-radius: 10px;
  }
  .el-input__prefix {
    color: rgb(240, 199, 218);
    margin-left: 5px;
    top: 2px;
    i {
      font-size: 18px;
    }
  }
}
.btns {
  display: inline-flex;
  justify-content: space-evenly;
  align-content: center;
  margin-top: 15px;
}
.button {
  background-image: linear-gradient(120deg, #a6c0fe 0%, #f68084 100%);
  color: white;
  border: none;
}
.loginButton {
  order: 2;
  width: 110px;
  height: 45px;
  margin: 0 70px;
  margin-top: -10px;
  font-size: 26px;
  border-radius: 200px;
}
.goRegButton {
  order: 1;
  width: 90px;
  height: 30px;
  font-size: 14px;
  border-radius: 20px;
}
.checkButton {
  order: 3;
  width: 90px;
  height: 30px;
  font-size: 14px;
  border-radius: 20px;
}
</style>
