<template>
  <div class="bg">
    <el-row type="flex" justify="center">
      <el-col :span="8">
        <div style="width: 100px; height: 100px; margin: auto">
          <el-image
            :src="headIco"
            :fit="'fill'"
            style="border-radius: 50px"
          ></el-image>
        </div>
      </el-col>
    </el-row>
    <el-row>
      <el-col style="margin-top: 40px; color: white; font-size: 24px"
        >login</el-col
      >
    </el-row>
    <el-row type="flex" justify="center" style="margin-top: 25px">
      <el-col :xs="20" :md="10">
        <el-input placeholder="username" v-model="username" clearable>
        </el-input>
      </el-col>
    </el-row>
    <el-row type="flex" justify="center" style="margin-top: 25px">
      <el-col :xs="20" :md="10">
        <el-input
          placeholder="password"
          v-model="password"
          clearable
          show-password
        >
        </el-input>
      </el-col>
    </el-row>
    <el-row type="flex" justify="center" style="margin: 25px 0">
      <el-col :xs="20" :md="10">
        <el-row>
          <el-col :span="6" :push="2">
            <el-checkbox>remember me</el-checkbox>
          </el-col>
          <el-col :offset="12" :span="6" :pull="2">
            <el-link :underline="false">forget?</el-link>
          </el-col>
        </el-row>
      </el-col>
    </el-row>

    <el-row type="flex" justify="center">
      <el-col :xs="20" :md="10">
        <el-row>
          <el-col :span="15">
            <el-button :round="true" @click="login">login</el-button>
          </el-col>
          <el-col :span="8" :offset="1">
            <el-button :round="true" @click="register">register</el-button>
          </el-col>
        </el-row>
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  data(){
    return {
      username: this.$route.params.username != undefined?this.$route.params.username:'shazhi',
      password: this.$route.params.password != undefined?this.$route.params.password:'123456',
      headIco: require ('asset/ico.jpg' )
    }
  },
  methods:{
    login(){
      this.$store
        .dispatch('login',{username:this.username,password:this.password})
        .then(result=>{
          if(result) {
            this.$message({message: 'login successfully',type: 'success'})
            Promise.all([this.$store.dispatch("user/security/querySecuritiesByUsername",{userName: this.$store.state.user.username}),this.$store.dispatch("user/getInfo",this.$store.state.user.username)])
              .then(()=>{
                this.$router.push({name:'index'})
              })
          }
          else this.$message({
            message: 'login faid',
            type: 'error'
          })
        })
    },
    register(){
      this.$store
        .dispatch('register',{username:this.username,password:this.password})
          .then(code=>{
            if (code == 1) {
              this.$message({message:'register successfully',type:'success'})
            }else{
              this.$message({message:'register fail',type: 'error'})
            }
        })
    }
  }
}
</script>

<style scoped>
.bg {
  padding-top: 100px;
  text-align: center;
  height: calc(100vh);
  background: url("../assets/bg.jpg");
  background-size: cover;
  overflow: hidden;
}

div /deep/ input {
  border-radius: 30px;
  background: rgba(128, 128, 128, 0.3);
  color: white;
  border: 1px black solid;
}

div /deep/ .el-checkbox__label .el-divider__text,
.el-link {
  display: inline-block;
  padding-left: 10px;
  line-height: 19px;
  font-size: 17px;
  color: white;
}
div /deep/ button {
  width: 100%;
  text-align: center;
  padding: 0;
  background: rgba(0, 0, 0, 0);
  color: white;
}
</style>