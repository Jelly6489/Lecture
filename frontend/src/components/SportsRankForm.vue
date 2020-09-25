<template>
  <v-app id="inspire">
    <v-app-bar
      app
      dark
      shrink-on-scroll
      prominent
      src="@/assets/ball1.png"
    >
      <v-app-bar-nav-icon @click.stop="drawer = !drawer"></v-app-bar-nav-icon>
      <v-toolbar-title><div @click="home"><p class="text-h4 font-weight-black">Daily Sports</p></div></v-toolbar-title>
      <v-spacer></v-spacer>
      <slot name="rankbar"></slot>
    </v-app-bar>

    <v-navigation-drawer
      v-model="drawer"
      app
      temporary
      width="350px"
      color="amber lighten-5"
    >
    <div id="header" v-if="isAuthorized">

      <div>
        <v-img src="@/assets/HP4.png" aspect-ratio="3"></v-img>
        <br><span><v-icon x-large color="black">mdi-face</v-icon> {{ myinfo.auth }} 계정</span>
      </div>
        <v-icon x-large color="black">mdi-music-note</v-icon>
        <input type="file"
                id="soundFileInput"
                class="soundFileInput"
                accept="audio/*"
                @change="onAudioSelected"/>
        <audio
          class="player"
          controls
          autoplay
          loop
          rounded
          color= "red"
          ref="player"> <source src="" ref="source">
        </audio>
        <v-list dense color="brown lighten-5">
          <v-list-item @click.stop="left = !left">
            <v-list-item-action>
              <v-icon x-large color="brown">mdi-login</v-icon>
            </v-list-item-action>
            <v-list-item-content>
              <v-list-item-title id="login" @click="onClickLogout">로그아웃</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </v-list>

        <v-list dense color="blue lighten-5">
          <v-list-item @click.stop="left = !left">
            <v-list-item-action>
              <v-icon x-large color="blue">mdi-home</v-icon>
            </v-list-item-action>
            <v-list-item-content>
              <v-list-item-title @click="home">홈으로 이동</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </v-list>

        <v-list dense color="orange lighten-5">
          <v-list-item @click.stop="left = !left">
            <v-list-item-action>
              <v-icon x-large color="orange">mdi-book</v-icon>
            </v-list-item-action>
            <v-list-item-content>
              <v-list-item-title @click="category">카테고리별 분류 보기</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </v-list>

        <v-list dense color="orange lighten-5">
          <v-list-item @click.stop="left = !left">
            <v-list-item-action>
              <v-icon x-large color="yellow darken-2">mdi-star</v-icon>
            </v-list-item-action>
            <v-list-item-content>
              <v-list-item-title @click="rank">순위 보기</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </v-list>
    </div>

      <div id="header" v-else>
        <v-img src="@/assets/HP4.png" aspect-ratio="2.8"></v-img>
        <v-list dense color="lime lighten-5">
          <v-list-item @click.stop="left = !left">
            <v-list-item-action>
              <v-icon x-large color="lime">mdi-login</v-icon>
            </v-list-item-action>
            <v-list-item-content>
              <v-list-item-title @click="vueLogin">로그인</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </v-list>

        <v-list dense color="purple lighten-5">
          <v-list-item @click.stop="left = !left">
            <v-list-item-action>
              <v-icon x-large color="purple">mdi-account-circle</v-icon>
            </v-list-item-action>
            <v-list-item-content>
              <v-list-item-title @click="vueRegister">회원가입</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </v-list>

        <v-list dense color="blue lighten-5">
          <v-list-item @click.stop="left = !left">
            <v-list-item-action>
              <v-icon x-large color="blue">mdi-home</v-icon>
            </v-list-item-action>
            <v-list-item-content>
              <v-list-item-title @click="home">홈으로 이동</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </v-list>

        <v-list dense color="orange lighten-5">
          <v-list-item @click.stop="left = !left">
            <v-list-item-action>
              <v-icon x-large color="yellow darken-2">mdi-star</v-icon>
            </v-list-item-action>
            <v-list-item-content>
              <v-list-item-title @click="rank">순위 보기</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </v-list>
      </div>

    </v-navigation-drawer>

    <v-container>
      <v-content id="contents">
        <slot name="contents" class="font">
        </slot>
      </v-content>
    </v-container>

    <v-footer
      app
      color="amber"
      class="white--text"
      padless
    >
      <v-spacer></v-spacer>
      <v-card-text class="py-2 white--text text-center">
        {{ new Date().getFullYear() }} — <strong>&copy; Sports Gall</strong>
      </v-card-text>
    </v-footer>
  </v-app>
</template>

<script>
import router from '../router'

import { mapState, mapGetters, mapActions } from 'vuex'

export default {
  data: () => ({
    drawer: false,
    left: false
  }),
  computed: {
    ...mapState(['myinfo']),
    ...mapGetters(['isAuthorized'])
  },
  methods: {
    vueRegister () {
      (window.location.pathname !== '/VueRegister') ? router.push('/VueRegister') : router.go(0)
    },
    vueLogin () {
      (window.location.pathname !== '/VueLogin') ? router.push('/VueLogin') : router.go(0)
    },
    home () {
      (window.location.pathname !== '/') ? router.push('/') : router.go(0)
    },
    category () {
      (window.location.pathname !== '/') ? router.push('/') : router.go(0)
    },
    rank () {
      (window.location.pathname !== '/SportsRank') ? router.push('/SportsRank') : router.go(0)
    },
    suggest () {
      (window.location.pathname !== '/suggestedrank/list') ? router.push('/suggestedrank/list') : router.go(0)
    },
    savedrank () {
      (window.location.pathname !== '/savedrank/list') ? router.push('/savedrank/list') : router.go(0)
    },
    onClickLogout () {
      this.logout()
      alert('Logout')
      this.$router.push({ name: 'SportsRank' }).catch(err => {
        console.log('Logout Fail: ', err)
      })
    },
    onAudioSelected () {
      const uploadSound = event.target.files[0]
      const audioSrc = window.URL.createObjectURL(uploadSound)
      this.$refs.source.src = audioSrc
      this.$refs.player.load()
    },
    ...mapActions(['logout'])
  }
}
</script>
