<template>
  <div class="lowMg">
      <el-row>
      <el-col :span="10">
        <div style="padding-top: 4px">
          <el-avatar
            shape="square"
            :size="64"
            :fit="'contain'"
            :src="src + info.userHeadico"
          ></el-avatar>
        </div>
      </el-col>
      <el-col :span="14">
        <p class="out" style="font-size: 20px">{{ info.userName }}</p>
        <p class="out" style="color: black">Identify: {{ info.userId }}</p>
      </el-col>
    </el-row>
    <el-divider ></el-divider>
    <div class="tags">
      <el-tag
        v-for="role in info.roles"
        :key="role.roleId"
        style="margin: 1px"
        :style="{ background: bgs[role.roleId % bgs.length] }"
      >
        {{ role.roleName }}
      </el-tag>
    </div>
    <el-divider ></el-divider>
    <slot name="funcs"></slot>
  </div>
</template>

<script>
export default {
    props:['info'],
    data(){
        return {
            bgs:['#F64E60','#FFE2E5','#FFF4DE','#C9F7F5','#E1E9FF','gray','aqua']
        }
    }
}
</script>

<style scoped>
.out {
  line-height: 36px;
  height: 36px;
}

.tags {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
}
.lowMg>>>.el-divider--horizontal {
    display: block;
    height: 1px;
    width: 100%;
    margin: 10px 0;
}
</style>