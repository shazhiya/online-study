<template>
  <div>
      <p>profile</p>
      <p v-for="(value,attr) of profile" :key="attr" v-show="value!=null">{{attr}} : {{value}}</p>
  </div>
</template>

<script>
export default {
    created(){
        this.$store.dispatch('user/getProfile')
    },
    computed:{
        profile(){
            return this.$store.state.user.profile
        }
    }
}
</script>

<style scoped>
div{
    border: gray 2px solid;
}
</style>