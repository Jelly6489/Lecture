<template>
  <div id="app">
    <v-card>
      <v-responsive :max-height="680">
        <v-app id="inspire"><br><br>
          <v-app-bar
            app
            dark
            height="300px"
            src="@/assets/dawn2.png"
          ></v-app-bar>

            <form @submit.prevent="submit">
            <h1 class="font-weight-bold">회원가입</h1><br>
              <v-col
                cols="10"
                md="4">
                <v-text-field
                  input type="text"
                  v-model="userId"
                  class="userid"
                  label="ID"
                  required>
                </v-text-field><br>

                <v-text-field
                  input type="password"
                  v-model="userPw"
                  label="Password"
                  required>
                </v-text-field><br>

                <v-text-field
                  input type="text"
                  v-model="userName"
                  label="NickName"
                  required>
                </v-text-field><br>

              </v-col>
              <v-btn v-bind:style = "mystyle1" v-on:mouseover = "changebgcolor1" v-on:mouseout = "originalcolor1"
              class="mr-4" @click="submit">oK</v-btn>
              <v-btn v-bind:style = "mystyle2" v-on:mouseover = "changebgcolor2" v-on:mouseout = "originalcolor2"
              class="mr-4 btn_id1" @click="idCheck">ID 중복체크</v-btn>
              <v-btn dark v-bind:style = "mystyle3" v-on:mouseover = "changebgcolor3" v-on:mouseout = "originalcolor3"
              :to="{ name: 'SportsBoard' }">Back</v-btn>
              <v-btn class="btn_id2">shit</v-btn>
            </form>
        </v-app>
      </v-responsive>
    </v-card>
  </div>
</template>

<script>
import $ from 'jquery'
export default {
  name: 'AdminRegisterForm',
  data () {
    return {
      userId: '',
      userName: '',
      userPw: '',
      mystyle1: {
        backgroundColor: 'white'
      },
      mystyle2: {
        backgroundColor: 'white'
      },
      mystyle3: {
        backgroundColor: 'black'
      }
    }
  },
  mounted() {
    var mysql = require('mysql');
    var connection = mysql.createConnection({
      host: 'localhost',
      port: 3306,
      user: 'bitai',
      password: '456123',와
      database: 'testdb'
    })
    var query = connection.query('select user_id from member')
    $('.btn_id2').click( function() {
      if($('.userid').val() == query) {
          alert('사용 불가능')
          console.log('userId:' + query)
      }
    });
  },
  methods: {
    changebgcolor1: function () {
      this.mystyle1.backgroundColor = '#81D4FA'
    },
    originalcolor1: function () {
      this.mystyle1.backgroundColor = 'white'
    },
    changebgcolor2: function () {
      this.mystyle2.backgroundColor = '#81D4FA'
    },
    originalcolor2: function () {
      this.mystyle2.backgroundColor = 'white'
    },
    changebgcolor3: function () {
      this.mystyle3.backgroundColor = '#81D4FA'
    },
    originalcolor3: function () {
      this.mystyle3.backgroundColor = 'black'
    },
    submit () {
      console.log('this: ' + this.userId +
                  ', ' + this.userName +
                  ', ' + this.userPw)
      const { userId, userName, userPw } = this
      this.$emit('submit', { userId, userName, userPw })
    },
    idCheck () {
      console.log('AdminRegisterForm click()')
      const { userid } = this
      this.$emit('idCheck', { userid })
    }
  }
}
</script>
