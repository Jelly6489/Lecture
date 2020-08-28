<template>
  <div align="center" >
    <v-app id="inspire"><br>
      <form>
        <vue-list-read-form v-if="board" :board="board" @submit="onSubmit"/>
        <p v-else>Loading ...</p>
        <v-btn class="mr-4" type="submit" :to="{ name: 'VueModifyPage', params: { boardNo } }">수정</v-btn>
        <v-btn class="mr-4" @click="onDelete">삭제</v-btn>
        <v-btn :to="{ name: 'VueGall' }">Back</v-btn>
      </form>
    </v-app>
  </div>
</template>

<script>
import VueListReadForm from '@/components/VueListReadForm'
import { mapState, mapActions } from 'vuex'
import axios from 'axios'

export default {
  name: 'VueReadPage',
  props: {
    boardNo: {
      type: String,
      required: true
    }
  },
  components: {
    VueListReadForm
  },
  computed: {
    ...mapState([
      'board'
    ])
  },
  mounted () {
    console.log('VueReadPage created(): ' + this.boardNo)
    this.fetchBoard(this.boardNo)
      .catch(err => {
        alert(err.response.data.message)
        this.$router.push()
      })
  },
  methods: {
    ...mapActions([
      'fetchBoard'
    ]),
    onDelete () {
      const { boardNo } = this.board
      axios.delete(`http://localhost:7777/boards/${boardNo}`)
        .then(res => {
          alert('Delete Success')
          this.$router.push({ name: 'VueGall' })
        })
        .catch(err => {
          alert(err.response.data.message)
        })
    }
  }
}
</script>
