<template>
  <div class="page-wrapper">
    <b-card header="Редактирование сделки" class="big-card shadow">
      <deal-form
        v-if="deal !== null"
        :initialDeal="deal"
        :onCancel="onCancel"
        :onSave="onSave"
      />
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
import { getDealById, updateDeal } from "../api/deals";
import DealForm from "../components/DealForm.vue";

export default {
  props: ["id"],
  data() {
    return {
      deal: null,
      loading: false,
      error: null,
    };
  },
  created() {
    this.loadDeal();
  },
  methods: {
    async loadDeal() {
      this.loading = true;
      this.error = null;

      try {
        const res = await getDealById(this.id);
        this.deal = {
          id: res.data.id,
          requestedItemsIds: res.data.requestedItems.map((item) => item.id),
          givenItemId: res.data.givenItem.id,
          experienceAmount: res.data.experienceAmount,
          tradesPerCycle: res.data.tradesPerCycle,
        };
      } catch (e) {
        this.error = `Failed to load deal with id = ${this.id}`;
        console.error(e);
      } finally {
        this.loading = false;
      }
    },
    onCancel() {
      this.$router.push("/deals");
    },
    async onSave(deal) {
      await updateDeal(deal);
      this.$router.push("/deals");
    },
  },
  components: {
    DealForm,
  },
};
</script>
