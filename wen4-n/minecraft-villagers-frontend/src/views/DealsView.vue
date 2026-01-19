<template>
  <div class="page-wrapper">
    <b-card header="Список сделок" class="big-card shadow">
      <b-list-group>
        <b-list-group-item
          v-for="deal in deals"
          :key="deal.id"
          class="d-flex align-items-center"
        >
          <b-container fluid>
            <b-row class="d-flex align-items-center">
              <b-col cols="8">
                <deal-list-item :deal="deal" />
              </b-col>
              <b-col cols="2" class="d-flex justify-content-center">
                <b-button variant="primary" @click="onClickUpdate(deal.id)">
                  <b-icon icon="pencil" />
                </b-button>
              </b-col>
              <b-col cols="2" class="d-flex justify-content-center">
                <b-button variant="danger" @click="onDelete(deal.id)">
                  <b-icon icon="trash" />
                </b-button>
              </b-col>
            </b-row>
          </b-container>
        </b-list-group-item>
        <b-list-group-item
          class="d-flex align-items-center"
          button
          @click="onClickCreate()"
        >
          <b-container fluid> Создать новую сделку </b-container>
        </b-list-group-item>
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
import { deleteDealById, getAllDeals } from "../api/deals";
import DealListItem from "../components/DealListItem.vue";

export default {
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

    async onDelete(dealId) {
      await deleteDealById(dealId);
      this.loadDeals();
    },

    onClickUpdate(dealId) {
      this.$router.push(`/deals/${dealId}/update`);
    },

    onClickCreate() {
      this.$router.push("/deals/create");
    },
  },
  components: {
    DealListItem,
  },
};
</script>
