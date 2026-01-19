<template>
  <div class="page-wrapper">
    <b-card
      :header="
        villager &&
        `Житель ${villager.name} (${villager.profession} — Уровень ${villager.tradeLevel})`
      "
      class="big-card shadow"
    >
      <b-list-group v-if="villager !== null">
        <b-list-group-item
          v-for="deal in villager.deals"
          :key="deal.id"
          class="d-flex align-items-center"
        >
          <b-container fluid>
            <b-row class="align-items-center">
              <b-col cols="10">
                <deal-list-item :deal="deal" />
              </b-col>
              <b-col cols="2" class="d-flex justify-content-center">
                <b-button variant="danger" @click.stop="onRemoveDeal(deal.id)">
                  <b-icon icon="arrow-left-right" />
                </b-button>
              </b-col>
            </b-row>
          </b-container>
        </b-list-group-item>
        <b-list-group-item
          class="d-flex align-items-center"
          button
          @click="onClickAddDeal()"
        >
          <b-container fluid> Добавить сделку жителю </b-container>
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
import DealListItem from "../components/DealListItem.vue";
import { getVillagerById, removeDealFromVillager } from "../api/villagers";
export default {
  props: ["id"],
  data() {
    return {
      villager: null,
      loading: false,
      error: null,
    };
  },
  created() {
    this.loadVillager();
  },
  methods: {
    async loadVillager() {
      this.loading = true;
      this.error = null;

      try {
        const res = await getVillagerById(this.id);
        this.villager = res.data;
      } catch (e) {
        this.error = `Failed to load villager with id = ${this.id}`;
        console.error(e);
      } finally {
        this.loading = false;
      }
    },
    onClickAddDeal() {
      this.$router.push(`/villagers/${this.id}/deals/add`);
    },
    async onRemoveDeal(dealId) {
      await removeDealFromVillager(this.id, dealId);
      this.loadVillager();
    },
  },
  components: {
    DealListItem,
  },
};
</script>
