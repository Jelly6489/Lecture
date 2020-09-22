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
          <v-file-input
            v-model="files"
            color="deep-purple accent-4"
            counter
            label="File input"
            multiple
            placeholder="Select your files"
            prepend-icon="mdi-paperclip"
            outlined
            :show-size="1000"
          >
            <template v-slot:selection="{ index, text }">
              <v-chip
                v-if="index < 2"
                color="deep-purple accent-4"
                dark
                label
                small
              >
                {{ text }}
              </v-chip>

              <span
                v-else-if="index === 2"
                class="overline grey--text text--darken-3 mx-2"
              >
                +{{ files.length - 2 }} File(s)
              </span>
            </template>
          </v-file-input>
        </v-container>

        <div id = "btnex">
          <v-btn v-bind:style = "mystyle1" v-on:mouseover = "changebgcolor1" v-on:mouseout = "originalcolor1" class="mr-4" type="submit">작성</v-btn>
          <v-btn dark v-bind:style = "mystyle2" v-on:mouseover = "changebgcolor2" v-on:mouseout = "originalcolor2" :to="{ name: 'SportsGalleryView' }">취소</v-btn>
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
      files: [],
      title: '',
      writer: '',
      content: '',
      mystyle1: {
        backgroundColor: 'white'
      },
      mystyle2: {
        backgroundColor: 'black'
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
      this.mystyle2.backgroundColor = 'black'
    },
    onSubmit () {
      const { title, writer, content } = this
      this.$emit('submit', { title, writer, content })
    }
  }
}
</script>
