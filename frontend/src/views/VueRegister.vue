<template>
  <div align="center">
    <admin-register-form @submit="onSubmit"/>
  </div>
</template>

<script>
import axios from 'axios'
import AdminRegisterForm from '@/components/AdminRegisterForm.vue'

export default {
  name: 'VueRegister',
  components: {
    AdminRegisterForm
  },
  methods: {
    onSubmit (payload) {
      console.log('payload: ' + payload.userId +
                  ', ' + payload.userName +
                  ', ' + payload.userPw)
      const { userId, userName, userPw } = payload
      axios.post('http://localhost:7777/users/setup',
        { userId, userName, userPw })
        .then(res => {
          alert('회원가입 완료')
          this.$router.push({
            name: 'SportsBoard'
          })
        })
        .catch(err => {
          alert(err.response.data)
        })
    }
  }
}
</script>
