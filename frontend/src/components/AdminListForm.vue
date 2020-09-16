<template>
  <div id="app">
    <v-app id="inspire"><br><br>
      <form @submit.prevent="onSubmit">
        <h1>게시판 작성</h1>
        <v-container>
          <v-textarea
            background-color="light-blue"
            v-model="title"
            color="black"
            label="Title"
          ></v-textarea>

          <v-textarea
            background-color="grey lighten-2"
            v-model="writer"
            color="gray"
            label="Writer"
          ></v-textarea>

          <v-textarea
            background-color="amber lighten-4"
            v-model="content"
            color="orange orange-darken-4"
            label="Content"
          ></v-textarea>
        </v-container>

        <div id = "btnex">
          <v-btn v-bind:style = "mystyle1" v-on:mouseover = "changebgcolor1" v-on:mouseout = "originalcolor1" class="mr-4" type="submit">작성</v-btn>
          <v-btn v-bind:style = "mystyle2" v-on:mouseover = "changebgcolor2" v-on:mouseout = "originalcolor2" :to="{ name: 'VueGall' }">취소</v-btn>
        </div>
      </form>
    </v-app>
  </div>
</template>

<script>
export default {
  name: 'AdminListForm',
  data () {
    return {
      title: '',
      writer: '',
      content: '',
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
    onSubmit () {
      const { title, writer, content } = this
      this.$emit('submit', { title, writer, content })
    }
  }
}
</script>
