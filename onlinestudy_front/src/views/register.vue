<template>
  <div>
      <p>register</p>
      username: <input type="text" v-model="info.username"><br>
      password: <input type="password" v-model="info.password"><br>
      confirm: <input type="password" placeholder="confirm your password" v-model="cp"><br>
      <button @click="register">register</button>
      <button @click="gotoLogin">gotoLogin</button>
  </div>
</template>

<script>
export default {
    data(){
        return {
            info:{
                username: this.$route.params.username,
                password: this.$route.params.password
            },
            cp:''
        }
    },
    methods:{
        register(){
            if(this.cp!= this.info.password) {
                alert('confirm password differ to password')
                return
            }
            this.$store
            .dispatch('register',this.info)
            .then(code=>{
                if (code == 1) {
                    alert('success')
                    this.gotoLogin()
                }else{
                    alert('error')
                }
            })
        },
        gotoLogin(){
            this.$router.push({name:'login',params: this.info})
        }
    }
}
</script>

<style>

</style>