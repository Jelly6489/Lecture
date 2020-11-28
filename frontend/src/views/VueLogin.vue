<template>
  <div align="center">
    <admin-login-form @submit="onSubmit"/>
  </div>
</template>

<script>
import AdminLoginForm from '@/components/AdminLoginForm.vue'
import { mapActions } from 'vuex'

export default {
  name: 'VueLogin',
  components: {
    AdminLoginForm
  },
  methods: {
    onSubmit (payload) {
      console.log('VueLogin onSubmit()')
      this.login(payload).then(res => {
        res
        alert('로그인 성공')
        this.$router.push({ name: 'SportsBoard' })
      }).catch(err => {
        // alert(err.response.data.message)
        alert('Fail', + err)
      })
    },
    ...mapActions(['login'])
  }
}
</script>
