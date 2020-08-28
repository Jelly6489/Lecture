<template>
  <Layout>
    <template #menubar>
      <v-btn x-large rounded @click="start('soccer')" text color="indigo darken-4"
        style="padding: 10px; width: 150px;">
        <v-icon x-large color="indigo darken-4">mdi-soccer</v-icon>
        축구</v-btn>
      <v-btn x-large rounded @click="start('worldsoccer')" text color="indigo darken-4"
        style="padding: 10px; width: 150px;">
        <v-icon x-large color="indigo darken-4">mdi-soccer</v-icon>
        해외축구</v-btn>
      <v-btn x-large rounded @click="start('baseball')" text color="cyan"
        style="padding: 10px; width: 150px;">
        <v-icon x-large color="cyan">mdi-baseball</v-icon>
        야구</v-btn>
      <v-btn x-large rounded @click="start('worldbaseball')" text color="cyan"
        style="padding: 10px; width: 150px;">
        <v-icon x-large color="cyan">mdi-baseball</v-icon>
        해외야구</v-btn>
      <v-btn x-large rounded @click="start('golf')" text color="green accent-3"
        style="padding: 10px; width: 150px;">
        <v-icon x-large color="green accent-3">mdi-golf</v-icon>
        골프</v-btn>
      <v-btn x-large rounded @click="start('basketball')" text color="red"
        style="padding: 10px; width: 150px;">
        <v-icon x-large color="red">mdi-basketball</v-icon>
        농구</v-btn>
      <v-btn x-large rounded @click="start('esports')" text color="grey lighten-5"
        style="padding: 10px; width: 150px;">
        <v-icon x-large color="grey lighten-5">mdi-mouse</v-icon>
        e스포츠</v-btn>
      <v-btn x-large rounded :to="{ name: 'VueGall' }" text color="amber lighten-2"
        style="padding: 10px; width: 150px;">
        <v-icon x-large color="amber lighten-2">mdi-comment</v-icon>
        게시판</v-btn>
    </template>
      <template #content>
        <v-simple-table>
          <template v-slot:default>
            <thead>
              <tr>
                <th class="text-left">No.</th>
                <th class="text-left">제목</th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="list of lists" :key="list.title">
                <td style="color: gray">{{ list.newsNo }}</td>
                <td><a href="${list.address}">{{ list.title }}</a></td>
              </tr>
            </tbody>
          </template>
        </v-simple-table>
      </template>
  </Layout>
</template>

<script>
import Layout from '../components/Layout'
import { mapState } from 'vuex'

export default {
  components: { Layout },
  computed: {
    ...mapState({
      lists: state => state.lists
    })
  },
  methods: {
    clickNews (newsNo) {
      console.log('clickNews: ' + newsNo)
      this.$store.dispatch('crawlFindOne', newsNo)
    },
    start (category) {
      this.$store.dispatch('crawlFind', category)
    }
  }
}
</script>
