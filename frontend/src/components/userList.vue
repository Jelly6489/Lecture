<template>
  <div v-for="(user, index) in users" :key="index" class="user-wrap">
     <h2>No. {{index + 1}}</h2>
     <dl>
        <dt>아이디</dt>
        <dd>{{user.userid}}</dd>
        <dt>이름</dt>
        <dd>{{user.name}}</dd>
     </dl>
  </div>
<template>

<script>
export default {
  name: 'AdminSetupForm',
  data () {
    return {
      users: []
    }
  },
  created () {
    this.$http.get('/api/users')
      .then((response) => {
        this.users = response.data
      })
  }
  methods: {
    login: function (event) {
      this.$http.post('/api/users/login', {
        user: this.user
      })
      .then(
        (res) => {  //로그인 성공
          alert(res.data.message);
        },
        (err) => { // error 를 보여줌
          alert('Login failed! please check your id or password');
      })
      .catch(err => {
        alert(err);
      })
    }
  }
}
</script>