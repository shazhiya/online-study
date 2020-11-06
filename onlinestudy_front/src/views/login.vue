<template>
  <div>
      <p>login</p>
      username: <input type="text" v-model="username"><br>
      password: <input type="password" v-model="password"><br>
      <button @click="login">login</button>
      <button @click="gotoRegister">goto register</button>
  </div>
</template>

<script>
export default {
  data(){
    return {
      username: this.$route.params.username != undefined?this.$route.params.username:'shazhi',
      password: this.$route.params.password != undefined?this.$route.params.password:'123456'
    }
  },
  methods:{
    login(){
      this.$store
        .dispatch('login',{username:this.username,password:this.password})
        .then(result=>{
          if(result) alert('login success')
          else alert('login failed')
        })
    },
    gotoRegister(){
      this.$router.push({name: 'register',params:{username:this.username,password:this.password}})
    }
  }
}
</script>

<style>

</style>