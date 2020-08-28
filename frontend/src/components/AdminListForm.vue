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

        <div>
          <v-btn class="mr-4" type="submit">작성</v-btn>
          <v-btn :to="{ name: 'VueGall' }">취소</v-btn>
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
      content: ''
    }
  },
  methods: {
    onSubmit () {
      const { title, writer, content } = this
      this.$emit('submit', { title, writer, content })
    }
  }
}
</script>
