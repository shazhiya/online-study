<template>
  <div :style="{backgroundColor:func.bg}" @click="goto">
    function card: {{func.name}} 
  </div>
</template>

<script>
export default {
  props:['func'],
  methods:{
    goto(){
      this.$router.push({name:this.$props.func.name})
    }
  }
}
</script>

<style scoped>
div{
  border: 1px gray solid;
  margin: 10px;
  display: inline-block;
}
</style>