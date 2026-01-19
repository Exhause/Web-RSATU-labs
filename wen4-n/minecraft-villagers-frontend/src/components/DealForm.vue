<template>
  <b-form @submit.prevent="onClickSave">
    <b-form-group label="Количество опыта">
      <b-form-input
        v-model.number="deal.experienceAmount"
        type="number"
        min="0"
        required
      />
    </b-form-group>
    <b-form-group label="Количество сделок за раз">
      <b-form-input
        v-model.number="deal.tradesPerCycle"
        type="number"
        min="1"
        required
      />
    </b-form-group>
    <b-form-group label="Необходимые предметы">
      <b-form-select
        v-model="deal.requestedItemsIds"
        :options="itemOptions"
        multiple
        :select-size="items.length"
        required
      />
    </b-form-group>
    <b-form-group label="Получаемый предмет">
      <b-form-select
        v-model="deal.givenItemId"
        :options="itemOptions"
        required
      />
    </b-form-group>
    <div class="d-flex justify-content-end gap-2 mt-1">
      <b-button variant="secondary" @click="onClickCancel"> Отмена </b-button>
      <b-button variant="primary" type="submit" :disabled="saving">
        Сохранить
      </b-button>
    </div>
  </b-form>
</template>

<script>
import { getAllItems } from "../api/items";

export default {
  props: {
    initialDeal: {
      type: Object,
      required: true,
    },
    onCancel: {
      type: Function,
      required: true,
    },
    onSave: {
      type: Function,
      required: true,
    },
  },

  data() {
    return {
      deal: { ...this.initialDeal },
      items: [],
      loading: false,
      error: null,
      saving: false,
    };
  },

  computed: {
    itemOptions() {
      return this.items.map((item) => {
        return {
          value: item.id,
          text: `${item.name} (${item.quantity})`,
        };
      });
    },
  },

  created() {
    this.loadItems();
  },

  methods: {
    async loadItems() {
      this.loading = true;
      this.error = null;

      try {
        const res = await getAllItems();
        this.items = res.data;
      } catch (e) {
        this.error = "Failed to load items";
        console.error(e);
      } finally {
        this.loading = false;
      }
    },

    onClickCancel() {
      this.onCancel();
    },

    onClickSave() {
      this.saving = true;
      this.onSave(this.deal);
    },
  },
};
</script>
