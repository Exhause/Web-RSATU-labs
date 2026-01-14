<template>
  <div class="page-wrapper">
    <b-card header="Список сделок" class="big-card shadow">
      <b-list-group>
        <template v-for="deal in deals">
          <deal-list-item :key="deal.id" :deal="deal" />
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
import { getAllDeals } from "../api/deals";
import DealListItem from "../components/DealListItem.vue";

export default {
  data() {
    return {
      deals: [],
      loading: false,
      error: null,
    };
  },
  mounted() {
    this.loadDeals();
  },
  methods: {
    async loadDeals() {
      this.loading = true;
      this.error = null;

      try {
        const res = await getAllDeals();
        this.deals = res.data;
      } catch (e) {
        this.error = `Failed to load deals`;
        console.error(e);
      } finally {
        this.loading = false;
      }
    },
  },
  components: {
    DealListItem,
  },
};
</script>
