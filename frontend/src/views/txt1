<template>
  <div align="center">
    <admin-register-form @submit="onSubmit" @idCheck="onClick"/>
  </div>
</template>

<script>
import axios from 'axios'
import { mapActions } from 'vuex'
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
          res.status
          alert('회원가입 완료')
          this.$router.push({
            name: 'SportsBoard'
          })
        })
        .catch(err => {
          alert(err.response.data)
        })
    },
    onClick (payload) {
      console.log('VueRegister onClick()')
      this.checkId(payload).then(res => {
        res.status
        alert('사용 불가')
      }).catch(err => {
        err.status
        alert('사용 가능')
      })
    },
    ...mapActions(['checkId'])
  }
}
</script>
