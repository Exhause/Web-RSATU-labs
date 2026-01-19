<template>
  <div class="page-wrapper">
    <b-card header="Добавление сделки жителю" class="big-card shadow">
      <b-list-group>
        <b-list-group-item
          v-for="deal in deals"
          :key="deal.id"
          class="d-flex align-items-center"
          button
          @click="onAddDealToVillager(deal.id)"
        >
          <b-container fluid>
            <deal-list-item :deal="deal" />
          </b-container>
        </b-list-group-item>
      </b-list-group>
      <div class="d-flex justify-content-end gap-2 mt-1">
        <b-button variant="secondary" @click="onClickCancel()">
          Отмена
        </b-button>
      </div>
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
import { addDealToVillager } from "../api/villagers";
import DealListItem from "../components/DealListItem.vue";

export default {
  props: ["id"],
  data() {
    return {
      deals: [],
      loading: false,
      error: null,
    };
  },
  created() {
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
    async onAddDealToVillager(dealId) {
      await addDealToVillager(this.id, dealId);
      this.$router.push(`/villagers/${this.id}`);
    },
    onClickCancel() {
      this.$router.push(`/villagers/${this.id}`);
    },
  },
  components: {
    DealListItem,
  },
};
</script>
