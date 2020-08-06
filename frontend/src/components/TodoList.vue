<template>
  <div>
    <h1>Todo List</h1>
    <ul>
      <li v-for="(todoItem, idx) in todoItems"
          v-bind:key="idx">
          {{ todoItem }}
          <button v-on:click="removeTodo(todoItem, idx)">
          Delete
          </button>
      </li>
    </ul>
  </div>
</template>

<script>

export default {
  data () {
    return {
      // todoItems: ['item1', 'item2', 'item3']
    }
  },
  props: ['todoItems'],
  methods: {
    removeTodo (todoItem, idx) {
      console.log('removeTodo')
      // this.todoItems.splice(idx, 1)
      this.$emit('removeTodo', todoItem, idx)
    }
  }
}

</script>

<style scoped>
  div {
    background-color: #c3d4fb
  }
</style>
