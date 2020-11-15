<template>
  <div>
      <el-row :gutter="30">
          <el-col v-for="i in 10" :key="i" :xs="12" :md="6">
              <func></func>
          </el-col>
      </el-row>
  </div>
</template>

<script>
import func from '../card/functionCard'
export default {
    components:{
        func
    }
}
</script>

<style scoped>
div{
    margin-top: 30px;
}
</style>