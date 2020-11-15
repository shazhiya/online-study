<template>
  <div>
      a beautiful banner
      <br>
      <router-link :to="{'name':'profile'}">myProfile</router-link>
  </div>
</template>

<script>
export default {

}
</script>

<style scoped>
 div{
   border: gray 2px solid;
 }
</style>