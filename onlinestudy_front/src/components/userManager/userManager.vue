<template>
  <div>
    <el-card class="card">
      <el-divider content-position='left'>user manage</el-divider>
      <user-list
        ref="userList"
        :start="start"
        :width="width"
        :search="''"
        :pages="$store.state.user.userPage.totalPage"
        :total="$store.state.user.userPage.totalUser"
        :userList="userList"
        :callBacks="{ currentChange, sizeChange, searchChange ,changeRole,changeEnable}"
      />
    </el-card>
  </div>
</template>

<script>
import userList from 'component/userManager/userList'
export default {
    data(){
      return {
        query: '',
        role:'',
        enable:'',
        start:1,
        width:16,
      }
    },
    components:{
      userList
    },
    created(){
      this.$store.dispatch('security/allRole')
    },
    mounted(){
      this.load()
    },
    methods:{
      change(){
        this.load()
      },
      load(){
        this.$store.dispatch('user/getUserPage',{
          start:this.start - 1,
          width:this.width,
            query:JSON.stringify({
              userName:this.query,
              roles:[{
                roleId: this.role
              }],
              userEnable:this.enable
            })
         })
       },
       currentChange(v){
         this.start = v
       },
       sizeChange(v){
         this.width = v
       },
       changeRole(role){
         this.role = role
       },
       changeEnable(enable){
         this.enable = enable
       },
       searchChange(v){
         this.query = v
       },
       openAddUser(){
         this.$router.push({name:'addUser'})
       }
    },
    computed:{
      userList(){
            return this.$store.state.user.userPage.userList
        }
    },
    watch:{
      start(){
        this.load()
      },
      width(){
        this.load()
      },
      query(){
        this.load()
      },
      role(){
        this.load()
      },
      enable(){
        this.load()
      }
    }
}
</script>

<style scoped>
.card {
  border: black 1px solid;
  border-radius: 30px;
}
</style>