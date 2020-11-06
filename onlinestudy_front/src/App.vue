<template>
  <div id="app">
    <router-view/>
  </div>
</template>

<script>
export default {
  mounted(){
    this.$router.push({name:'login'})
  }
}

</script>

<style>

</style>
