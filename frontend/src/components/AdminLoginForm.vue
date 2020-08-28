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
            <v-btn color="light-blue" class="mr-4" type="submit">Login</v-btn>
            <v-btn :to="{ name: 'SportsBoard' }">Back</v-btn>
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
      password: ''
    }
  },
  methods: {
    submit () {
      console.log('AdminLoginForm submit()')
      const { userid, password } = this
      this.$emit('submit', { userid, password })
    }
  }
}
</script>
