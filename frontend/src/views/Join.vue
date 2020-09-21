<template>
  <div class="home">
    <div id="header">
      <router-link :to="{ name: 'Home' }"
         class="nav-link"
         active-class="active">
        Home
      </router-link>
      <router-link :to="{ name: 'Test' }"
          class="nav-link"
          active-class="active">
        Test
      </router-link>
     </div>
     <h1>회원가입</h1>
     <div id = "app">
        <p v-bind:key=todo v-for="todo in todos">
          {{ todo.text }} <input v-model="todo.text"><br>
        </p>
        <p>Gender
        <input type="checkbox" v-model="GenValue" value="Y"> 남성
        <input type="checkbox" v-model="GenValue" value="X"> 여성
        </p>
        <select v-model="LcValue">
                <option disabled="disabled">Local</option>
                <option value="S">서울</option>
                <option value="I">인천</option>
                <option value="K">경기도</option>
                <option value="Ka">강원도</option>
                <option value="C">충청도</option>
                <option value="J">전라도</option>
                <option value="G">경상도</option>
        </select><br><br>
        <button v-on:click="joinMsg">Join</button>
     </div>
  </div>
</template>

<script>
import Vue from 'vue'
import cookies from 'vue-cookies'

Vue.use(cookies)

export default {
  data: function () {
    return {
      todos: [
        { text: 'ID' },
        { text: 'PW' },
        { text: 'Nickname' },
        { text: 'Name' },
        { text: 'Age' },
        { text: 'Phone' },
        { text: 'E-mail' }
      ]
    }
  },
  methods: {
    signMsg: function () {
      alert('회원가입 완료')
    }
  }
}
</script>
