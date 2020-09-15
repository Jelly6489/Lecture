<template>
  <div id="app" align="center">
    <v-app id="inspire"><br>
      <h1>게시글 확인</h1><br>
      <form @submit.prevent="onSubmit">
        <v-col
          cols="10"
          md="4">
          <v-text-field
            input type="text"
            v-model="board.boardNo"
            label="No"
            readonly
            required>
          </v-text-field><br>

          <v-text-field
            input type="text"
            v-model="board.regDate"
            label="Date"
            readonly
            required>
          </v-text-field><br>

          <v-text-field
            input type="text"
            v-model="board.title"
            label="Title"
            readonly
            required>
          </v-text-field><br>

          <v-text-field
            input type="text"
            v-model="board.writer"
            label="Writer"
            readonly
            required>
          </v-text-field><br>

        <v-container>
          <v-textarea
            background-color="amber lighten-4"
            v-model="board.content"
            color="orange orange-darken-4"
            label="Content"
            readonly
            required
          ></v-textarea>
        </v-container>
        </v-col>
      </form>
    </v-app>
  </div>
</template>

<script>
export default {
  name: 'VueListReadForm',
  props: {
    board: {
      type: Object,
      required: true
    }
  }
}
</script>
