<template>
  <div id="app" align="center" >
    <v-app id="inspire"><br>
      <form @submit.prevent="onSubmit">
        <v-card width="1000" color="#F0F4C3"><br>
        <h1>게시글 수정</h1><br>
          <v-col
            cols="10"
            md="8">
            <v-text-field
              input type="text"
              v-model="board.boardNo"
              label="No"
              disabled
              >
            </v-text-field><br>

            <v-text-field
              input type="text"
              v-model="board.regDate"
              label="Date"
              disabled
              >
            </v-text-field><br>

            <v-text-field
              input type="text"
              v-model="title"
              label="Title"
              >
            </v-text-field><br>

            <v-text-field
              input type="text"
              v-model="board.writer"
              label="Writer"
              disabled
              >
            </v-text-field><br>
          </v-col>

          <v-col
            cols="10"
            md="8">
            <v-textarea
              background-color="amber lighten-4"
              v-model="content"
              color="orange orange-darken-4"
              label="Content"
            ></v-textarea>
          </v-col>

          <div>
            <v-btn v-bind:style = "mystyle1" v-on:mouseover = "changebgcolor1" v-on:mouseout = "originalcolor1"
            class="mr-4" type="submit">수정</v-btn>
            <v-btn dark v-bind:style = "mystyle2" v-on:mouseover = "changebgcolor2" v-on:mouseout = "originalcolor2"
            :to="{ name: 'VueReadPage', params: { boardNo: board.boardNo.toString() } }">취소</v-btn>
          </div><br>
        </v-card>
      </form>
    </v-app>
  </div>
</template>

<script>
export default {
  name: 'VueListModifyForm',
  props: {
    board: {
      type: Object,
      required: true
    }
  },
  data () {
    return {
      title: '',
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
      const { title, content } = this
      this.$emit('submit', { title, content })
    }
  },
  created () {
    this.title = this.board.title
    this.content = this.board.content
  }
}
</script>
