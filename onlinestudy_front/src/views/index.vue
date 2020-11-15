<template>
  <div>
    <el-container>
      <el-header style="width: 75%; margin: auto">
          <navbar></navbar>
      </el-header>
      <el-main style="width: 75%; margin: auto; margin-top: 30px">
          <router-view name="main"/>
      </el-main>
    </el-container>
  </div>
</template>

<script>
import navbar from 'component/nav/index'
export default {
    components:{
        navbar
    }
}
</script>

<style scoped>
#main {
  border: black 3px solid;
}
.el-container {
  background-image: url(https://cdn.jsdelivr.net/gh/mt-theme/metron-assets@3.0.2/metron/media/bg/bg-01-450.jpg);
  background-repeat: no-repeat;
  background-size: 100% 250px;
}

</style>