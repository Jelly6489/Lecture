<template>
  <v-app id="inspire"><br>
    <form @submit.prevent="submit">
      <v-container grid-list-md>
        <v-layout row wrap>

          <!-- <v-flex xs12 sm6 md4 v-if="!paginatedData || (Array.isArray(paginatedData) && paginatedData.length === 0)">
            List is empty
          </v-flex> -->

          <!-- <v-flex xs12 sm6 md4 v-else v-for="page in paginatedData" :key="page.boardNo">
            {{ page }}
          </v-flex> -->
          <v-flex xs12>
            <v-data-table
              :headers="headers"
              :items="paginatedData"
              class="elevation-1">
              <template slot="items" slot-scope="props">
                <td>{{ props.item.boardNo }}</td>
                <td>
                  <router-link :to="{ name: 'VueReadPage',
                          params: { boardNo: item.boardNo.toString() } }">
                    {{ props.item.title }}
                  </router-link>
                </td>
                <td>{{ props.item.writer }}</td>
                <td>{{ props.item.regDate }}</td>
              </template>
            </v-data-table>
          </v-flex>
        </v-layout>
      </v-container>
    </form>
  </v-app>
</template>

<script>
export default {
  name: 'SportsGalleryForm',
  data () {
    return {
      board: [],
      headers: [
        { text: '번호', value: 'boardNo', sortable: false, class: 'hidden-sm-and-down' },
        { text: '제목', value: 'title', sortable: false },
        { text: '글쓴이', value: 'writer', sortable: false },
        { text: '작성일', value: 'regDate', sortable: false }
      ]
    }
  },
  props: {
    listArray: {
      type: Array,
      required: true
    },
    pageSize: {
      type: Number,
      default: 5
    },
    boards: {
      type: Array
    }
  },
  computed: {
    pageCount () {
      const listLen = this.listArray.length
      const listSize = this.pageSize

      let page = Math.floor(listLen / listSize)
      if (listLen % listSize > 0) {
        page += 1
      }

      return page
    },
    paginatedData () {
      const start = this.pageNum * this.pageSize
      const end = start + this.pageSize
      return this.listArray.slice(start, end)
    }
  }
}
</script>
