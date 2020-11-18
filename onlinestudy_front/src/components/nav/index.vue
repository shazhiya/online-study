<template>
  <div class="div">
    <el-row type="flex" justify="space-between" :gutter="30">
      <el-col :span="6">
        <h2 class="title-3d">shazhi</h2>
      </el-col>
      <el-col :xs="15" :md="17">
        <el-button
          class="el-icon-menu"
          size="small"
          @click="drawer = true"
        ></el-button>
      </el-col>
      <el-col :xs="3" :md="1">
        <el-avatar
          shape="square"
          :size="32"
          :fit="'contain'"
          :src="src + $store.state.user.userInfo.userHeadico"
          v-popover:popover
        ></el-avatar>
      </el-col>
    </el-row>

    <el-drawer
      :visible.sync="drawer"
      :direction="direction"
      :title="'menu'"
      :show-close="false"
      :size="'60%'"
    >
      <el-menu>
        <el-menu-item @click="$router.push({name:'index'})">
          home
        </el-menu-item>
        <el-menu-item @click="$router.push({name:'mine',query: { userName: $store.state.user.username}})">
          mine
        </el-menu-item>
        <el-menu-item @click="$router.push({name:'userManager'})" v-if="judge('userManager')">
          user manage
        </el-menu-item>
        <el-menu-item @click="$router.push({name:'courseManager'})" v-if="judge('courseManager')">
          course manager
        </el-menu-item>
      </el-menu>
    </el-drawer>

    <el-popover ref="popover" placement="bottom" width="300" trigger="click">
        <show :info='$store.state.user.userInfo'>
          <div slot="funcs">
            <el-button type="primary" @click="$router.push({name:'login'})">logout</el-button>
            <el-button type="primary">notify</el-button>
          </div>
        </show>
    </el-popover>
  </div>
</template>

<script>
import map from '../../funcMapToName'
import show from '../userManager/userCardShow'
export default {
   data(){
        return {
            drawer: false,
            direction: 'ltr',
            url: require ('asset/ico.jpg')
        }
    },
    components:{show},
    methods:{
      judge(name){
        return map(name)
      }
    }
}
</script>

<style scoped>
.title-3d {
  color: #fafafa;
  white-space: nowrap;
  padding-top: 15px;
  letter-spacing: 0;
  text-shadow: 0px 1px 0px #999, 0px 2px 0px #888, 0px 3px 0px #777,
    0px 4px 0px #666, 0px 5px 0px #555, 0px 6px 0px #444, 0px 7px 0px #333,
    0px 8px 7px #001135;
}

.div >>> button {
  margin-top: 20px;
  float: right;
}

.div >>> span {
  margin-top: 20px;
}
</style>