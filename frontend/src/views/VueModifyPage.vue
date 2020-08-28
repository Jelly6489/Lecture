<template>
  <div align="center">
    <vue-list-modify-form v-if="board" :board="board" @submit="onSubmit"/>
    <p v-else>Loading ...</p>
  </div>
</template>

<script>
import VueListModifyForm from '@/components/VueListModifyForm'
import { mapState, mapActions } from 'vuex'
import axios from 'axios'

export default {
  name: 'VueModifyPage',
  components: {
    VueListModifyForm
  },
  props: {
    boardNo: {
      type: String,
      required: true
    }
  },
  computed: {
    ...mapState(['board'])
  },
  created () {
    console.log('VueModifyPage created()')
    this.fetchBoard(this.boardNo)
      .catch(err => {
        alert(err.response.data.message)
        this.$router.back()
      })
  },
  mounted () {
    console.log('VueModifyPage created(): ' + this.boardNo)
    this.fetchBoard(this.boardNo)
      .catch(err => {
        alert(err.response.data.message)
        this.$router.push()
      })
  },
  methods: {
    onSubmit (payload) {
      const { title, content } = payload
      console.log('VueModifyPage payload: ' + payload)
      axios.put(`http://localhost:7777/boards/${this.boardNo}`, { title, content })
        .then(res => {
          alert('Modify Success')
          console.log('res: ' + res.data)
          this.$router.push({
            name: 'VueReadPage',
            params: { boardNo: res.data.boardNo.toString() }
          })
        })
        .catch(err => {
          alert(err.response.data.message)
        })
    },
    ...mapActions([
      'fetchBoard'
    ])
  }
}
</script>
