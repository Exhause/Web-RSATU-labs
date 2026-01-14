<template>
  <div class="page-wrapper">
    <b-card header="Список деревень" class="big-card shadow">
      <b-list-group flush>
        <template v-for="village in villages">
          <village-list-item :key="village.id" :village="village" />
        </template>
      </b-list-group>
      <template v-if="loading">
        <p>Loading...</p>
      </template>
      <template v-if="error !== null">
        <p>Error! {{ error }}</p>
      </template>
    </b-card>
  </div>
</template>

<script>
import { getAllVillages } from "../api/villages";
import VillageListItem from "../components/VillageListItem.vue";

export default {
  data() {
    return {
      villages: [],
      loading: false,
      error: null,
    };
  },
  mounted() {
    this.loadVillages();
  },
  methods: {
    async loadVillages() {
      this.loading = true;
      this.error = null;

      try {
        const res = await getAllVillages();
        this.villages = res.data;
      } catch (e) {
        this.error = "Failed to load villages";
        console.error(e);
      } finally {
        this.loading = false;
      }
    },
  },
  components: {
    VillageListItem,
  },
};
</script>
