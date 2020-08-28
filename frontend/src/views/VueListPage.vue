<template>
  <div align="center">
    <admin-list-form @submit="onSubmit"/>
  </div>
</template>

<script>
import AdminListForm from '@/components/AdminListForm.vue'
import axios from 'axios'

export default {
  name: 'VueListPage',
  components: {
    AdminListForm
  },
  methods: {
    onSubmit (payload) {
      console.log('VueListPage onSubmit()')
      const { title, content, writer } = payload
      axios.post('http://localhost:7777/boards', { title, writer, content })
        .then(res => {
          console.log(res)
          alert('작성 완료')
          this.$router.push({
            name: 'VueReadPage',
            params: { boardNo: res.data.boardNo.toString() }
          })
        })
        .catch(err => {
          alert(err.response.data.message)
        })
    }
  }
}
</script>
