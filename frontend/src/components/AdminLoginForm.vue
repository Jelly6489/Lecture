<template>
  <div id="app" align="center">
    <v-card>
      <v-responsive :max-height="680">
        <v-app id="inspire"><br><br>
          <v-app-bar
            app
            dark
            height="300px"
            src="https://picsum.photos/1920/1080?random"
          ></v-app-bar>
          <form @submit.prevent="submit">
          <h1 class="font-weight-bold text-decoration-underline">Login</h1><br>
            <v-col
              cols="10"
              md="4"
              >
              <v-text-field
                input type="text"
                v-model="userid"
                label="ID"
                required>
              </v-text-field><br>

              <v-text-field
                input type="password"
                v-model="password"
                label="Password"
                required>
              </v-text-field><br>
            </v-col>
            <v-btn v-bind:style = "mystyle1" v-on:mouseover = "changebgcolor1" v-on:mouseout = "originalcolor1"
            class="mr-4" type="submit">Login</v-btn>
            <v-btn v-bind:style = "mystyle2" v-on:mouseover = "changebgcolor2" v-on:mouseout = "originalcolor2"
            :to="{ name: 'SportsBoard' }">Back</v-btn>
          </form>
        </v-app>
      </v-responsive>
    </v-card>
  </div>
</template>

<script>
export default {
  name: 'AdminLoginForm',
  data () {
    return {
      userid: '',
      password: '',
      mystyle1: {
        backgroundColor: 'white'
      },
      mystyle2: {
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
    submit () {
      console.log('AdminLoginForm submit()')
      const { userid, password } = this
      this.$emit('submit', { userid, password })
    }
  }
}
</script>
