<template>
  <div id="app" align="center" >
    <v-app id="inspire"><br><br>
      <form @submit.prevent="onSubmit">
      <h1>게시글 수정</h1><br>
        <v-col
          cols="10"
          md="4">
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

          <v-text-field
            input type="text"
            v-model="content"
            label="Content"
            rows="5"
            >
          </v-text-field><br>

        </v-col>
        <div>
          <v-btn class="mr-4" type="submit">수정</v-btn>
          <v-btn :to="{ name: 'VueReadPage', params: { boardNo: board.boardNo.toString() } }">취소</v-btn>
        </div>
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
      content: ''
    }
  },
  methods: {
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
