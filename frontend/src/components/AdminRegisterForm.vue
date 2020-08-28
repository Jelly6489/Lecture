<template>
  <div id="app" align="center">
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
              <v-btn color="light-blue" class="mr-4" type="submit">oK</v-btn>
              <v-btn :to="{ name: 'SportsBoard' }">Back</v-btn>
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
      userPw: ''
    }
  },
  methods: {
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
