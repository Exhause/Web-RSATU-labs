<template>
  <b-container fluid class="p-0">
    <b-row class="align-items-center">
      <b-col cols="5">
        <div v-for="requestedItem in deal.requestedItems" class="fw-bold">
          {{ `${requestedItem.name} (${requestedItem.quantity})` }}
        </div>
      </b-col>
      <b-col cols="2" class="d-flex justify-content-center">
        <b-icon
          icon="arrow-right"
          font-scale="1.5"
          animation="cylon"
          variant="dark"
        />
      </b-col>
      <b-col cols="5">
        <div class="fw-bold">
          {{ `${deal.givenItem.name} (${deal.givenItem.quantity})` }}
        </div>
      </b-col>
    </b-row>
    <b-row class="align-items-center">
      <b-col cols="7">
        <div class="text-muted small">
          {{ `${deal.experienceAmount} опыта за сделку` }}
        </div>
      </b-col>
      <b-col cols="5">
        <div class="text-muted small">
          {{ `${deal.tradesPerCycle} сделок за раз` }}
        </div>
      </b-col>
    </b-row>
  </b-container>
</template>

<script>
export default {
  props: {
    deal: {
      type: Object,
      required: true,
    },
  },
};
</script>
