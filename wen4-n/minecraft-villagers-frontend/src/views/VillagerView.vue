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
          <deal-list-item :deal="deal" />
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
import { getVillagerById } from "../api/villagers";
export default {
  props: ["id"],
  data() {
    return {
      villager: null,
      loading: false,
      error: null,
    };
  },
  mounted() {
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
  },
  components: {
    DealListItem,
  },
};
</script>
