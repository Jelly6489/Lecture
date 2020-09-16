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
              class="mr-4" type="submit">oK</v-btn>
              <v-btn v-bind:style = "mystyle2" v-on:mouseover = "changebgcolor2" v-on:mouseout = "originalcolor2"
              class="mr-4" type="@click">ID 중복체크</v-btn>
              <v-btn v-bind:style = "mystyle3" v-on:mouseover = "changebgcolor3" v-on:mouseout = "originalcolor3"
              :to="{ name: 'SportsBoard' }">Back</v-btn>
            </form>
        </v-app>
      </v-responsive>
    </v-card>
  </div>
</template>

<script>
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
        backgroundColor: 'white'
      }
    }
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
      this.mystyle3.backgroundColor = 'white'
    },
    submit () {
      console.log('this: ' + this.userId +
                  ', ' + this.userName +
                  ', ' + this.userPw)
      const { userId, userName, userPw } = this
      this.$emit('submit', { userId, userName, userPw })
    }
  }
}
</script>
