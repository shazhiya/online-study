<template>
  <el-popover placement="top-start" :width="width" trigger="hover" class="but">
    <el-button slot="reference">
      <el-card
        class="card"
        :body-style="body"
        :style="{ background: bgs[info.userId % bgs.length],position: 'relative'}"
      >
        <div class="disable" v-if="!info.userEnable">
          disable
        </div>
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
      </el-card>
    </el-button>
    <show :info='info'>
      <slot slot="funcs" name="funcs"></slot>
    </show>
  </el-popover>
</template>

<script>
import show from './userCardShow'
export default {
    props:['info','bg','width'],
    data(){
        return {
            body:{
                padding:0,
                paddingLeft:'0px'
            },
            bgs:['#F64E60','#FFE2E5','#FFF4DE','#C9F7F5','#E1E9FF','gray','aqua']
        }
    },
    components:{show}
}
</script>

<style scoped>
.card {
  width: 200px;
  display: inline-block;
}

.but >>> button {
  margin: 0;
  padding: 0;
}
.inline {
  display: inline-block;
}

.out {
  line-height: 36px;
  height: 36px;
}

.tags {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
}
.disable{
  position: absolute;
  top: 40%;
  left: 40%;
  color: red;
  font-size: 26px;
  transform: rotate(30deg);
  border: red 2px double;
}
</style>