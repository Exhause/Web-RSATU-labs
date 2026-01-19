<template>
  <div class="page-wrapper">
    <b-card header="Создание новой сделки" class="big-card shadow">
      <deal-form
        :initialDeal="{
          id: 0,
          experienceAmount: 0,
          tradesPerCycle: 1,
          requestedItemsIds: [],
          givenItemId: null,
        }"
        :onCancel="onCancel"
        :onSave="onSave"
      />
    </b-card>
  </div>
</template>
<script>
import { createDeal } from "../api/deals";
import DealForm from "../components/DealForm.vue";

export default {
  methods: {
    onCancel() {
      this.$router.push("/deals");
    },
    async onSave(deal) {
      await createDeal(deal);
      this.$router.push("/deals");
    },
  },
  components: {
    DealForm,
  },
};
</script>
