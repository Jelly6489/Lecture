<template>
  <SportsRankForm>
    <template #rankbar>
      <v-btn x-large rounded @click="starts('프리미어리그')" text color="indigo darken-4"
        style="padding: 10px; width: 150px;">
        <v-icon x-large color="indigo darken-4">mdi-soccer</v-icon>
        프리미어리그</v-btn>
      <v-btn x-large rounded @click="starts('프리메라리가')" text color="indigo darken-4"
        style="padding: 10px; width: 150px;">
        <v-icon x-large color="indigo darken-4">mdi-soccer</v-icon>
        라리가</v-btn>
      <v-btn x-large rounded @click="starts('분데스리가')" text color="cyan"
        style="padding: 10px; width: 150px;">
        <v-icon x-large color="cyan">mdi-soccer</v-icon>
        분데스리가</v-btn>
      <v-btn x-large rounded @click="starts('세리에a')" text color="cyan"
        style="padding: 10px; width: 150px;">
        <v-icon x-large color="cyan">mdi-soccer</v-icon>
        세리에A</v-btn>
      <v-btn x-large rounded @click="starts('k리그1')" text color="green accent-3"
        style="padding: 10px; width: 150px;">
        <v-icon x-large color="green accent-3">mdi-soccer</v-icon>
        k리그-1</v-btn>
      <v-btn x-large rounded @click="starts('리게앙')" text color="red"
        style="padding: 10px; width: 150px;">
        <v-icon x-large color="red">mdi-soccer</v-icon>
        리게-앙</v-btn>
      <v-btn x-large rounded :to="{ name: 'SportsGalleryView' }" text color="amber lighten-2"
        style="padding: 10px; width: 150px;">
        <v-icon x-large color="amber lighten-2">mdi-soccer</v-icon>
        게시판</v-btn>
    </template>
      <template #contents>
        <v-simple-table>
          <template v-slot:default>
            <thead>
              <tr>
                <th class="text-left">No.</th>
                <th class="text-left">팀</th>
                <th class="text-left">경기</th>
                <th class="text-left">승</th>
                <th class="text-left">무</th>
                <th class="text-left">패</th>
                <th class="text-left">득점</th>
                <th class="text-left">실점</th>
                <th class="text-left">득실차</th>
                <th class="text-left">승점</th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="list of rlists" :key="list.team">
                <td style="color: gray">{{ list.rankNo }}</td>
                <td><a @click="clickRank(list.rankNo)">{{ list.team }}</a></td>
                <td style="color: gray">{{ list.games }}</td>
                <td style="color: gray">{{ list.win }}</td>
                <td style="color: gray">{{ list.draw }}</td>
                <td style="color: gray">{{ list.lose }}</td>
                <td style="color: gray">{{ list.wp }}</td>
                <td style="color: gray">{{ list.lp }}</td>
                <td style="color: gray">{{ list.difference }}</td>
                <td style="color: gray">{{ list.gp }}</td>
              </tr>
            </tbody>
          </template>
        </v-simple-table>
      </template>
  </SportsRankForm>
</template>

<script>
import SportsRankForm from '../components/SportsRankForm'
import { mapState } from 'vuex'

export default {
  components: { SportsRankForm },
  computed: {
    ...mapState({
      rlists: state => state.rlists
    })
  },
  methods: {
    clickRank (rankNo) {
      console.log('clickRank: ' + rankNo)
      this.$store.dispatch('rankFindOne', rankNo)
    },
    starts (value) {
      console.log('value:' + value)
      this.$store.dispatch('rankFind', value)
    }
  }
}
</script>
