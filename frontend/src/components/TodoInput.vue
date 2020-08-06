<template>
  <div>
    <h2 class="monospace">Todo Input</h2>
    <input type="text" v-model="newTodoItem"
        v-on:keypress.enter="addTodo">
    <button v-on:click="addTodo">Add</button>
  </div>
</template>

<script>

export default {
  data () {
    return {
      newTodoItem: ''
    }
  },
  methods: {
    addTodo () {
      if (this.newTodoItem !== '') {
        var value = this.newTodoItem && this.newTodoItem.trim()
        console.log('addTodo:' + value)
        this.$emit('addTodo', value)
        this.clearInput()
      }
    },
    clearInput () {
      this.newTodoItem = ''
    }
  }
}

</script>

// css를 보면 스타일링을 좀 더 할 수 있다.
<style scoped>
  div {
    background-color: #f8fba6
  }
  .monospace {
    font-family: "Lucida Console", Courier, monospace;
    text-decoration: underline;
    color: #ff00ff;
  }
</style>
