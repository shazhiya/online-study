<template>
  <div>
    <el-row :gutter="30">
      <el-col :md="8">
        <el-card class="card">
          <div slot="header">
            <div style="display: inline-block">
              <el-avatar
                shape="square"
                :src="info.userHeadico?this.src + info.userHeadico:this.src+'headIco/default.jpg'"
                :size="64"
              ></el-avatar>
            </div>
            <div
              style="
                display: inline-block;
                height: 68px;
                overflow: hidden;
                padding-left: 15px;
              "
            >
              <p style="font-size: 28px">{{ info.userName }}</p>
              <p style="color: gray; font-size: 14px">
                {{ info.userIntro }}
              </p>
            </div>
          </div>

          <div class="body">
              <el-row >
                <el-col :span="6"><div>email:</div></el-col>
                <el-col :span="18" class="textRight gray"><div>{{info.userEmail}}</div></el-col>
              </el-row>
              <el-row class="margin">
                <el-col :span="10"><div>register date:</div></el-col>
                <el-col :span="14" class="textRight gray"><div>{{info.userRegisterdate}}</div></el-col>
              </el-row>
              <el-row class="margin">
                <el-col :span="8"><div>telephone:</div></el-col>
                <el-col :span="16" class="textRight gray"><div>{{info.userTelephone}}</div></el-col>
              </el-row>
              <el-row class="margin">
                <el-col :span="4"><div>roles:</div></el-col>
                <el-col :span="20" class="textRight gray">
                  <el-tag effect="dark" size="mini" hit:true v-for="role of info.roles" :key="role.roleId" style="margin-left:1px">
                      {{role.roleName}}
                  </el-tag>
                </el-col>
              </el-row>
              <el-divider></el-divider>
              <el-menu v-if="$store.state.user.profile.userName == $store.state.user.username">
                <el-menu-item>
                  <span class="el-icon-s-home" @click="$router.push({name:'mine'})"> home</span>
                </el-menu-item>
                <el-menu-item>
                  <span class="el-icon-edit" @click="$router.push({name:'edit'})"> edit</span>
                </el-menu-item>
              </el-menu>
          </div>

        </el-card>
      </el-col>
      <el-col :md="16" :xs="24">
        <el-card class="card">
          <router-view name="mine"></router-view>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
    data(){
        return {
           
        }
    },
    created(){
        this.$store.dispatch('user/getProfile',this.$route.query.userName)
    },
    computed:{
        info(){
            return this.$store.state.user.profile
      }
    }
}
</script>

<style scoped>
.margin{
    margin-top: 20px;
}
.textRight {
  text-align: right;
}

.body{
  font-size: 14px;
}
.gray{
    color: gray;
}
</style>