<template>
  <div align="center">
    <sport-board-list-form :list-array="pageArray"/>
  </div>
</template>

<script>
import axios from 'axios'
import SportBoardListForm from '@/components/SportBoardListForm.vue'

export default {
  name: 'VueGall',
  components: {
    SportBoardListForm
  },
  data () {
    return {
      pageArray: []
    }
  },
  created () {
    axios.get('http://localhost:7777/boards')
      .then(res => {
        console.log(res)
        this.pageArray = res.data
      })
      .catch(err => {
        console.log(err)
      })
  }
}
</script>
