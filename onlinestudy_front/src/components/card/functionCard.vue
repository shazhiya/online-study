<template>
  <div style="width:100%; display:inline-block;">
      <el-card class="card">
          <div slot="header">
              
          </div>
      </el-card>
  </div>
</template>

<script>
export default {

}
</script>

<style scoped>
.card{
    width: 100%;
    display: inline-block;
    height: 150px;
    background: #C9F7F5;
    border-radius: 15px;
    overflow: hidden;
    position: relative;
}

.card::after{
    content: "";
    position: absolute;
    left: 60%;
    width: 500px;
    display: block;
    height: 500px;
    background: white;
    transform: rotate(20deg);
    z-index: 12;
}

</style>